package ir.maktabsharif.util;


import ir.maktabsharif.repository.impl.StudentRepositoryImpl;


public class StudentThread {
    static StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();

    public static void run() {
        System.out.println(java.lang.Thread.currentThread().getName());
        studentRepository.getAll();
    }
}

