import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WebPage {

    private ExecutorService executor;
    private HTML html;
    /**
     * Bound executor to a fixed thread pool size
     */
    public WebPage(int threadNumber, HTML html){
        this.executor = Executors.newFixedThreadPool(threadNumber);
        this.html = html; // Oz > all > html

    }

    /**
     * submit the download of the image specified by the url
     * to be executed by thread pool
     */
    public Future<Image> loadImage(URL url){
        return executor.submit(() -> downloadImageFromURL(url));
    }

    /**
     * Download the image specified by the url
     */
    public Image downloadImageFromURL(URL url){
        //HIDDEN
    }

    /**
     * Load all images of the page
     */
    public List<Future<Image>> loadImages(List<URL> urls){
        List<Future<Image>> images = new ArrayList<>(urls.size());
        for (URL url: urls) {
            images.add(loadImage(url));
        }
        return images;
    }

    /**
     * Load the page while images are being downloaded
     */
    private void displayPageWithoutImage(){
        //HIDDEN
    }

    /**
     * Display all images on the page
     */
    private void displayImages(List<Image> images){
        //HIDDEN
    }

    /**
     * load the page
     */
    public void loadPage(){
        // First the image are downloaded asynchronously
        List<Future<Image>> futures = loadImages(this.html.getUrls());
        // While the image are being downloaded, we display the page without them
        displayPageWithoutImage();
        // Then we need all images to display them
        List<Image> images = new ArrayList<Image>(futures.size());
        try{
            for(Future<Image> future : futures){
                // the "get()" function is waiting for the result of the future task (here download the images)
                images.add(future.get());
            }
        } catch(InterruptedException e){

        } catch (ExecutionException e){

        }
        // we can display now images on the page
        displayImages(images);
        // shut down the executor service now
        executor.shutdown();

    }

}
