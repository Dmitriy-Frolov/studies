import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

  public static void main(String[] args) {
    Document document;
    Elements elementIMG;
    try {
      document = Jsoup.connect("https://lenta.ru/").get();
      elementIMG = document.getElementsByTag("img");
      for (Element element : elementIMG){
        String src = element.attr("abs:src");
        System.out.println(src);
        downloadImage(src);
      }
    }catch (IOException | NullPointerException exception){
      exception.getStackTrace();
    }
  }

  private static void downloadImage(String src) throws MalformedURLException {
    String imageName = src.substring(src.lastIndexOf('/') + 1);
    URL urlImage = new URL(src);

    try (InputStream inputStream = urlImage.openStream();
         OutputStream outputStream = new FileOutputStream("Images/" + imageName)){

      inputStream.transferTo(outputStream);

      System.out.println("Image saved: " + imageName);
    }catch (IOException exception){
      exception.getStackTrace();
    }
  }

}
