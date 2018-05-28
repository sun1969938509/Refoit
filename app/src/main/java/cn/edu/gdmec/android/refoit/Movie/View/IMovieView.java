package cn.edu.gdmec.android.refoit.Movie.View;

import cn.edu.gdmec.android.refoit.Bean.MovieBean;
import cn.edu.gdmec.android.refoit.Bean.NewsBean;

/**
 * Created by Administrator on 2018/5/23.
 */

public interface IMovieView {
    void showMovie(MovieBean movieBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(String error);
}
