package lessons.java;
import lessons.java.data_sources.ReceiversApiDataSource;
import lessons.java.domain.ReceiversService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://receivers.api.ecohub.eco/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ReceiversApiDataSource receiversApiDataSource = retrofit.create(ReceiversApiDataSource.class);
        ReceiversService service = new ReceiversService(receiversApiDataSource);
        service.fetchAll();

    }
}
