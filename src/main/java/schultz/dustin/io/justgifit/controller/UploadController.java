package schultz.dustin.io.justgifit.controller;

import java.io.File;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;

@RestController
public class UploadController {

    private final static Logger log = (Logger) LoggerFactory.getLogger(MethodHandles.lookup()
            .lookupClass());


    @Value("${multipart.location}")
    private String location;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.IMAGE_GIF_VALUE)

    public String upload(@RequestPart("file")MultipartFile file,
                         @RequestParam("start") int start,
                         @RequestParam("end") int end,
                         @RequestParam("speed") int speed,
                         @RequestParam("repeat") boolean repeat) throws IOException {
        File videoFile = new File(location + "/" + System
                .currentTimeMillis()+".mp4");
        file.transferTo(videoFile);
        log.info("Saved file to {}", videoFile.getAbsolutePath());
        return "";

    }
}
