package ir.maktabsharif;


import ir.maktabsharif.util.StudentThread;


public class Main {

    public static void main(String[] args) {

        while (true) {
            try {
                StudentThread.run();
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        Address address = Address.builder()
//                .country("Iran")
//                .city("Tehran")
//                .street("Tajrish")
//                .zipCode("123456").build();


//        while (true){
//            try {
//                studentRepository.getAll();
//                Thread.sleep(2000);
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//        }


//        try {
//            Optional<StudentEntity> studentEntity = studentRepository.findById(1L);
//            Optional<StudentEntity> studentEntity2 = studentRepository.findById(2L);
//            Optional<StudentEntity> studentEntity3 = studentRepository.findById(3L);
//            Optional<StudentEntity> studentEntity4 = studentRepository.findById(4L);
//            Thread.sleep(2000);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }

//        studentEntity.ifPresent(System.out::println);

//        Optional<StudentEntity> studentEntity2 = studentRepository.getAll();
//        System.out.println(studentEntity.get());

//        StudentThread studentThread = new StudentThread();
//        studentThread.run();


//        EntityManager factory = DbManager.getFactory();
//        factory.getTransaction().begin();
//        StudentEntity build = StudentEntity.builder()
//                .firstName("John")
//                .lastName("Doe")
//                .dob(new Date(System.currentTimeMillis()))
//                .build();
//        factory.persist(build);
//        factory.getTransaction().commit();
//        DbManager.close();
//
//        EntityManager factory1 = DbManager.getFactory();
//        factory.getTransaction().begin();
//        StudentEntity studentEntity = factory1.find(StudentEntity.class, 1L);
//        System.out.println(studentEntity);
//        factory.getTransaction().commit();
//        DbManager.close();
//
//        EntityManager factory2 = DbManager.getFactory();
//        factory2.getTransaction().begin();
//        String FIND_BY_NATIONAL_CODE = "from StudentEntity s where s.nationalCode=:nation";
//        TypedQuery<StudentEntity> query = factory2.createQuery(FIND_BY_NATIONAL_CODE, StudentEntity.class);
//        query.setParameter("nation", "13123123123");
//        StudentEntity singleResult = query.getSingleResult();
//        System.out.println(singleResult);
//        factory2.getTransaction().commit();
//        DbManager.close();
//
//        EntityManager factory3 = DbManager.getFactory();
//        factory3.getTransaction().begin();
//        StudentEntity studentEntity2 = factory3.find(StudentEntity.class, 1L);
//        factory3.remove(studentEntity2);
//        factory3.getTransaction().commit();
//        DbManager.close();
//
//
//        EntityManager factory4 = DbManager.getFactory();
//        factory4.getTransaction().begin();
//        StudentEntity studentEntity3 = factory4.find(StudentEntity.class, 1L);
//        studentEntity3.setFirstName("Jack");
//        studentEntity3.setLastName("Smith");
//        factory4.merge(studentEntity3);
//        factory4.getTransaction().commit();
//        factory4.close();


//                CourseEntity courseEntity = CourseEntity
//                .builder()
//                .title("java")
//                .unit(1000)
//                .build();
//
//        BaseService<CourseEntity> baseService = new BaseServiceImpl<>(new BaseRepositoryImpl<>(new EntityManagerProvider()));
//        baseService.save(courseEntity);
    }
}
