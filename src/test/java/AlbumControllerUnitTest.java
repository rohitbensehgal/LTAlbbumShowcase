
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.app.albumapi.controllers.AlbumController;
import com.app.albumapi.model.Image;
import com.app.albumapi.service.AlbumService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class AlbumControllerUnitTest {

    @Mock
    private AlbumService albumService;

    @InjectMocks
    private AlbumController albumController;

    public AlbumControllerUnitTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAlbumByIdNumber_ValidIdNumber_ReturnsImages() throws Exception {
        String albumIdNumber = "3";

        List<Image> images = new ArrayList<>();
        images.add(new Image(3,4, "hello", "url.com", "url.com"));

        when(albumService.getImageList(anyString())).thenReturn(images);

        List<Image> result = albumController.findAlbumByIdNumber(albumIdNumber);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertFalse(result.isEmpty());
    }

    @Test
    public void testFindAlbumByIdNumber_InvalidIdNumber_ThrowsException() {
        String albumIdNumber = "invalid";

        assertThrows(Exception.class, () -> albumController.findAlbumByIdNumber(albumIdNumber));
    }

    @Test
    public void testFindImagesByTitle_ImagesFound_ReturnsRefinedImages() throws Exception {
        String titleQuery = "hello";

        List<Image> images = new ArrayList<>();
        images.add(new Image(1,1, "does not contain", "url.com", "url.com"));
        images.add(new Image(2,2, "hello", "url.com", "url.com"));
        images.add(new Image(2,3, "does not contain", "url.com", "url.com"));
        images.add(new Image(3,4, "hello", "url.com", "url.com"));

        when(albumService.getImageList(anyString())).thenReturn(images);

        List<Image> result = albumController.findImagesByTitle(titleQuery);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertFalse(result.isEmpty());
    }

    @Test
    public void testFindImagesByTitle_NoImagesFound_ThrowsException() {
        String titleQuery = "invalid";

        assertThrows(Exception.class, () -> albumController.findImagesByTitle(titleQuery));
    }

    @Test
    public void testFindImageById_ImageFound_ReturnsImage() throws Exception {
        String id = "1";

        List<Image> images = new ArrayList<>();
        images.add(new Image(1,1, "does not contain", "url.com", "url.com"));
        images.add(new Image(2,2, "hello", "url.com", "url.com"));
        images.add(new Image(2,3, "does not contain", "url.com", "url.com"));
        images.add(new Image(3,4, "hello", "url.com", "url.com"));

        when(albumService.getImageList(anyString())).thenReturn(images);

        Image result = albumController.findImageById(id);

        assertNotNull(result);
        assertEquals(Integer.valueOf(id), result.getId());
    }

    @Test
    public void testFindImageById_ImageNotFound_ThrowsException() {
        String id = "invalid";

        assertThrows(Exception.class, () -> albumController.findImageById(id));
    }
}