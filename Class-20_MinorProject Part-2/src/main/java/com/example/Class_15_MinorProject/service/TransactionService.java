package com.example.Class_15_MinorProject.service;

import com.example.Class_15_MinorProject.dto.InitiateTransactionRequest;
import com.example.Class_15_MinorProject.models.*;
import com.example.Class_15_MinorProject.repository.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired StudentService studentService;
    @Autowired AdminService adminService;
    @Autowired BookService bookService;
    @Autowired
    TransactionDao transactionDao;

    @Value("${student.allowed.duration}")
    Integer allowedDuration;

    @Value("${student.allowed.max-books}")
    Integer maxBooksAllowed;

    @Value("${student.fine-per-day}")
    Integer finePerDay;


    public String initiateTxn(InitiateTransactionRequest initiateTransactionRequest) throws Exception {
        return initiateTransactionRequest.getTransactionType() == TransactionType.ISSUE ?
                issueBook(initiateTransactionRequest) :
                returnBook(initiateTransactionRequest);
    }

    /**
     * Issue a book (Issuance) -> {studentRollNumber, bookId, adminId}
     *      1. Validate the request => student, book and admin is valid or not
     *      2. Validate if book is available or not => If book is already issue on someone else's name
     *      3. Validate if the book can be issued to a person or not => We need to check if student has issue limit
     *          available in his account
     *      4. Entry in transaction table => pending status
     *      5. Assign book to a student => Update student column in book table
     *      6. Update the status
     **/
    private String issueBook(InitiateTransactionRequest initiateTransactionRequest) throws Exception {

//  1. Validate the request => student, book and admin is valid or not
        Student student = validateStudent(initiateTransactionRequest.getStudentRollNumber());
        if(student == null) {
            throw new Exception("Invalid student roll number");
        }

        Admin admin = validateAdmin(initiateTransactionRequest.getAdminId());
        if(admin == null) {
            throw new Exception("Invalid admin");
        }

        Book book = validateBook(initiateTransactionRequest.getBookId());
        if(book == null) {
            throw new Exception("Invalid book");
        }
// 2. Validate if book is available or not => If book is already issue on someone else's name
        if(book.getStudent() != null) {
            throw new Exception("This book is already issued to " + book.getStudent().getName());
        }

//  3.  Validate if the book can be issued to a person or not => We need to check if student has issue limit
//             available in his account
        if(student.getBookList().size() >= maxBooksAllowed) {
            throw new Exception("Issue limit reached for this student");
        }

    Transaction transaction = null;
    try {
        transaction = Transaction.builder()
                .transactionId(UUID.randomUUID().toString())
                .student(student)
                .book(book)
                .admin(admin)
                .transactionStatus(TransactionStatus.PENDING)
                .transactionType(TransactionType.ISSUE)
                .build();

// 4. Make entry in the trans table
        transactionDao.save(transaction);

// 5. Assign book to student
        book.setStudent(student);
        bookService.createOrUpdateBook(book);
// 6. Update the status
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
    } catch (Exception e) {
        assert transaction != null;
        transaction.setTransactionStatus(TransactionStatus.FAILURE);
    } finally {
        assert transaction != null;
        transactionDao.save(transaction);
    }

    return transaction.getTransactionId();

    }


    /**
     * 1. Validate the request
     * 2. Get the corresponding issue transaction
     * 3. Entry in trxn table
     * 4. Due date of book, currentDate - issueDate > allowedDuration => fine calculation
     * 5. If there is fine => get the fine
     * 6. Deallocate the book from student's name => book table
     * 7. Update transaction status
     */

    private String returnBook(InitiateTransactionRequest initiateTransactionRequest) throws Exception {
        Student student = validateStudent(initiateTransactionRequest.getStudentRollNumber());
        if(student == null) {
            throw new Exception("Invalid student roll number");
        }

        Admin admin = validateAdmin(initiateTransactionRequest.getAdminId());
        if(admin == null) {
            throw new Exception("Invalid admin");
        }

        Book book = validateBook(initiateTransactionRequest.getBookId());
        if(book == null) {
            throw new Exception("Invalid book");
        }

        // 2. Get the corresponding issue transaction
        Transaction issuanceTransaction = transactionDao.findTransactionByStudentAndBookAndTransactionTypeOrderByIdDesc(
                student, book, TransactionType.ISSUE
        );


        Transaction transaction = null;
        try {
            Integer fine = calculateFine(issuanceTransaction.getCreatedOn());


            transaction = Transaction.builder()
                    .transactionId(UUID.randomUUID().toString())
                    .student(student)
                    .book(book)
                    .admin(admin)
                    .fine(fine)
                    .transactionStatus(TransactionStatus.PENDING)
                    .transactionType(TransactionType.RETURN)
                    .build();

            transactionDao.save(transaction);

//         5. Assign book to student
            book.setStudent(null);
            bookService.createOrUpdateBook(book);
// 6. Update the status
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        } catch (Exception e) {
            assert transaction != null;
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
        } finally {
            assert transaction != null;
            transactionDao.save(transaction);
        }

        return transaction.getTransactionId();
    }

    private Student validateStudent(String studentRollNumber) {
        try {
            return studentService.findStudent("rollNumber", studentRollNumber);
        } catch (Exception e) {
            return null;
        }

    }

    private Book validateBook(Integer bookId) {
        try {
            return bookService.findBook("id", String.valueOf(bookId)).getFirst();
        } catch (Exception e) {
            return null;
        }
    }

    private Admin validateAdmin(Integer adminId) {
        return adminService.findAdmin(adminId);
    }

    private Integer calculateFine(Date issuanceDateTime) {
        long issuanceTimeInMillis = issuanceDateTime.getTime();
        long currentTime = System.currentTimeMillis();

        long diff = currentTime-issuanceTimeInMillis;

        long daysPassed = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        if(daysPassed > allowedDuration) {
            return (int)((daysPassed - allowedDuration)*finePerDay);
        }
        return 0;
    }



}


