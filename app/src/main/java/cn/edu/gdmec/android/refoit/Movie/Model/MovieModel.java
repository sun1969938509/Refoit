package cn.edu.gdmec.android.refoit.Movie.Model;

import java.io.IOException;

import cn.edu.gdmec.android.refoit.Bean.MovieBean;
import cn.edu.gdmec.android.refoit.Bean.NewsBean;
import cn.edu.gdmec.android.refoit.Http.Api;
import cn.edu.gdmec.android.refoit.Http.RetrofitHelper;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/5/23.
 */

public class MovieModel implements IMovieModel {

    @Override
    public void loadMovie(String total, final IOnMovieListener iOnMovieListener) {
        RetrofitHelper retrofitHelper=new RetrofitHelper(Api.MOVIE_HOST);
        retrofitHelper.getMovie(total).enqueue(new Callback<MovieBean>(){
            @Override
            public void onResponse(Call<MovieBean> call, Response<MovieBean> response) {
                if(response.isSuccessful()){
                    iOnMovieListener.success(response.body());
                }else{
                    iOnMovieListener.fail("");
                }
            }

            @Override
            public void onFailure(Call<MovieBean> call, Throwable t) {
                iOnMovieListener.fail(t.toString());
            }
        });

    }

}
