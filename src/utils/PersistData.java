package utils;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import models.User;

public class PersistData {

  private static String filePath = "users.ser";
  private ObjectOutputStream oos;

  public void save(List<User> users) {
    try {
     /*  if (oos == null) {
        oos = new ObjectOutputStream(new FileOutputStream(filePath));
      } */
      oos = new ObjectOutputStream(new FileOutputStream(filePath));

      for (int i = 0; i < users.size(); i++) {
        oos.writeObject(users.get(i));
      }

      oos.close();
      System.out.println("Done");

    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  public List<User> getAllUsers() {

    List<User> users = new ArrayList<User>();

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
      while (true) {
        users.add((User) ois.readObject());
      }
    } catch (EOFException ex) {
      // fim da leitura aqui
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return users;
  }

}
