package step;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;


public class OnFailure extends TestListenerAdapter {

    @Step("Test fail attachments")
    @Override
    public void onTestFailure(ITestResult tr) {
        saveScreenshot(captureScreenShot());
        getSystemProperties();
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    private byte[] captureScreenShot() {
        try {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            return imageInByte;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return "Attachment Content Empty, can't create screenshot".getBytes();
    }

    @Attachment(value = "System Environment", type = "text/plain")
    public byte[] getSystemProperties() {
        Properties props = System.getProperties();
        StringBuilder result = new StringBuilder();
        for (String prop : props.stringPropertyNames()) {
            result.append(prop)
                    .append(" = ")
                    .append(System.getProperty(prop))
                    .append("\n");
        }
        return result.toString().getBytes();
    }


}
