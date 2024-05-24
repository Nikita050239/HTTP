package lessons.java.domain;

import lessons.java.data_sources.ReceiversApiDataSource;
import lessons.java.models.InRadiusDto;
import lessons.java.models.ReceiverModel;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class ReceiversService {
    final ReceiversApiDataSource receiversApiDataSource;
    private int currentPage = 0;
    private final int pageSize = 10;

    public ReceiversService(ReceiversApiDataSource receiversApiDataSource) {
        this.receiversApiDataSource = receiversApiDataSource;
    }

    public void fetchAll() throws IOException {
        int lastCount = pageSize;
        while (lastCount == pageSize) {
            InRadiusDto dto = new InRadiusDto(0,0,100000,0,pageSize);
            Call<List<ReceiverModel>> repos = receiversApiDataSource.listReceivers(dto);
            Response<List<ReceiverModel>> res = repos.execute();
            assert res.body() != null;
            currentPage++;
            lastCount = res.body().size();
            for (ReceiverModel receiver : res.body()) {
                System.out.println(receiver);
            }
        }
    }
}
