package App;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.enqueue("Diego");
        server.enqueue("Iker");
        server.enqueue("Manuel");
        System.out.println(server.getSize());
        for(int i = 0; i < 20; i++){
            System.out.println(server.getTail().getName());
            server.rotate();
            Thread.sleep(1000);   
        }
    }
}
