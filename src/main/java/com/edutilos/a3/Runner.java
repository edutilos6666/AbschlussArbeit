package com.edutilos.a3;

/**
 * Created by edutilos on 11.05.18.
 */
public class Runner {
    public static void main(String[] args) {
//        test1();
        String sep = "===================================================";
        test2();
        System.out.println(sep);
        test3();
        System.out.println(sep);
        test4();
        System.out.println(sep);
        test5();
        System.out.println(sep);
        test6();
        System.out.println(sep);
    }

    private static void test6() {
        Relation rel = new Relation("R", new UniqueList<String>("A", "B", "C", "D", "E"));
        Relation r1 = new Relation("R1", new UniqueList<String>("A", "B","C", "E"));
        Relation r2 = new Relation("R2", new UniqueList<String>("A", "C", "D"));
        Relation r3 = new Relation("R3", new UniqueList<String>( "D", "E"));
        Relation r4 = new Relation("R4", new UniqueList<String>( "C", "E"));

        FD fd1 = new FD("FD1", "A->CE");
        FD fd2 = new FD("FD2", "E->AD");
        FD fd3 = new FD("FD3", "CD->B");
        FD fd4 = new FD("FD4", "AD->E");
        UniqueList<FD> fds = new UniqueList<>(fd1, fd2, fd3,fd4);
        UniqueList<Relation> subset = new UniqueList<>(r1, r2,r3,r4);
        Matrix m = new Matrix(rel, fds, subset);
        m.printPretty();
        LosslessJoinAnalyzer.testIfLosslessJoin(m, subset);
    }

    private static void test5() {
        Relation rel = new Relation("R", new UniqueList<String>("A", "B", "C", "D", "E"));
        Relation r1 = new Relation("R1", new UniqueList<String>("A", "B","C", "E"));
        Relation r2 = new Relation("R2", new UniqueList<String>("A", "C", "D"));
        Relation r3 = new Relation("R3", new UniqueList<String>( "D", "E"));
        Relation r4 = new Relation("R4", new UniqueList<String>( "C", "E"));

        FD fd1 = new FD("FD1", "A->CE");
        FD fd2 = new FD("FD2", "E->AD");
        FD fd3 = new FD("FD3", "CD->B");
        UniqueList<FD> fds = new UniqueList<>(fd1, fd2, fd3);
        UniqueList<Relation> subset = new UniqueList<>(r1, r2,r3,r4);
        Matrix m = new Matrix(rel, fds, subset);
        m.printPretty();
        LosslessJoinAnalyzer.testIfLosslessJoin(m, subset);
    }


    private static void test4() {
        Relation rel = new Relation("R", new UniqueList<String>("A", "B", "C", "D", "E"));
        Relation r1 = new Relation("R1", new UniqueList<String>("A", "B","C", "E"));
        Relation r2 = new Relation("R2", new UniqueList<String>("A", "C", "D"));
        Relation r3 = new Relation("R3", new UniqueList<String>( "D", "E"));

        FD fd1 = new FD("FD1", "A->CE");
        FD fd2 = new FD("FD2", "E->AD");
        FD fd3 = new FD("FD3", "CD->B");
        UniqueList<FD> fds = new UniqueList<>(fd1, fd2, fd3);
        UniqueList<Relation> subset = new UniqueList<>(r1, r2,r3);
        Matrix m = new Matrix(rel, fds, subset);
        m.printPretty();
        LosslessJoinAnalyzer.testIfLosslessJoin(m, subset);
    }

    private static void test3() {
        Relation rel = new Relation("R", new UniqueList<String>("A", "B", "C", "D", "E"));
        Relation r1 = new Relation("R1", new UniqueList<String>("A", "B", "D","E"));
        Relation r2 = new Relation("R2", new UniqueList<String>("A", "C", "E"));
        FD fd1 = new FD("FD1", "BD->A");
        FD fd2 = new FD("FD2", "B->E");
        FD fd3 = new FD("FD3", "A->E");
        UniqueList<FD> fds = new UniqueList<>(fd1, fd2, fd3);
        UniqueList<Relation> subset = new UniqueList<>(r1, r2);
        Matrix m = new Matrix(rel, fds, subset);
        m.printPretty();
        LosslessJoinAnalyzer.testIfLosslessJoin(m, subset);
    }

    private static void test2() {
        Relation rel = new Relation("R", new UniqueList<String>("A", "B", "C", "D", "E"));
        Relation r1 = new Relation("R1", new UniqueList<String>("A", "B", "D"));
        Relation r2 = new Relation("R2", new UniqueList<String>("B", "C", "D", "E"));
        FD fd1 = new FD("FD1", "BD->A");
        FD fd2 = new FD("FD2", "B->E");
        FD fd3 = new FD("FD3", "A->E");
        UniqueList<FD> fds = new UniqueList<>(fd1, fd2, fd3);
        UniqueList<Relation> subset = new UniqueList<>(r1, r2);
        Matrix m = new Matrix(rel, fds, subset);
        m.printPretty();
        LosslessJoinAnalyzer.testIfLosslessJoin(m, subset);
    }

    private static void test1() {
        Relation r = new Relation("R", new UniqueList<>("A", "B", "C", "D", "E"));
        System.out.println(r.containsLetterToIndex(0));
        System.out.println(r.containsLetterToIndex(2));
    }
}
