package org.example;

public class Calculator {
    public static void main(String[] args) {

        int i = 10, j = 2;
        int result = Main.subtract(i, j);
        System.out.println(result);

    }
}

/*


 */


/*


    Maven - build tool
        Downloads the jars and add them to classpath,
        Add dependencies and build the code

    Why do we need Maven?
        1. Its not possible to download all libraries and add to classpath
        2. It helps in managing the entire project frm compile to build to deploy


Repository -> A place where you can save/persist your libraries

    1. Local Maven repo -> /.m2
    2. Central repo -> available on internet and have open source libraries, not everyone can push
    3. Remote repo -> Protected, private to an org
                nexus, JFrog artifactory



    Parse pom.xml -> present in local -> Yes -> adds the jar to classpath
                                      -> No -> If remote exist and found ->Yes -> download and add it to local
                                                                        -> No -> Central repo -> download to local repo

 */