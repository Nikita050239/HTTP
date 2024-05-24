package lessons.java.data_sources;

import lessons.java.models.InRadiusDto;
import lessons.java.models.ReceiverModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface ReceiversApiDataSource {
    @POST("inRadius")
    Call<List<ReceiverModel>> listReceivers(@Body InRadiusDto dto);
}
