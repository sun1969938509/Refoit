package cn.edu.gdmec.android.refoit.Movie.Model;

import cn.edu.gdmec.android.refoit.News.Model.IOnLoadListener;

/**
 * Created by Administrator on 2018/5/22.
 */

public interface IMovieModel {
   void loadMovie(String total,IOnMovieListener iOnMovieListener);
}
