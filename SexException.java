public class SexException extends Exception {
    public SexException() {

    }

    public void sexException(String i) {
        System.out.println("Exception: SexNotCorrectData");
        System.out.printf("это неверные данные: %s", i);
        System.out.println();
    }

}
