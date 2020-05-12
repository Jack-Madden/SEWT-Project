


public class Main implements Runnable{

    public static void main(String[] args)
    {
        ApplicationGUI window = new ApplicationGUI();

    }

        @Override
        public void run() {
            try{
                ApplicationGUI window = new ApplicationGUI();


            } catch (Exception e){
                e.printStackTrace();
            }
        } // run()

}
