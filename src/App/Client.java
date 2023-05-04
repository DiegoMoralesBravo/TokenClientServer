package App;

public class Client {
  private Client next;
  private boolean token = false;
  private String name;

  public Client(Client next, String name) {
    this.next = next;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Client getNext() {
    return next;
  }

  public boolean isToken() {
    return token;
  }

  public void setNext(Client next) {
    this.next = next;
  }

  public void setToken(boolean token) {
    this.token = token;
  }
}
