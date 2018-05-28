package cn.edu.gdmec.android.refoit.Movie.Model;

import cn.edu.gdmec.android.refoit.Bean.MovieBean;

/**
 * Created by Administrator on 2018/5/23.
 */

public interface IOnMovieListener {
    void success(MovieBean movieBean);
    void fail(String error);
}
