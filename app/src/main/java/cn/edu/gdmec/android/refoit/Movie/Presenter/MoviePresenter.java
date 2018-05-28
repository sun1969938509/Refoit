package cn.edu.gdmec.android.refoit.Movie.Presenter;

import android.widget.ImageView;

import cn.edu.gdmec.android.refoit.Bean.MovieBean;
import cn.edu.gdmec.android.refoit.Bean.NewsBean;
import cn.edu.gdmec.android.refoit.Http.Api;
import cn.edu.gdmec.android.refoit.Movie.Model.IMovieModel;
import cn.edu.gdmec.android.refoit.Movie.Model.IOnMovieListener;
import cn.edu.gdmec.android.refoit.Movie.Model.MovieModel;
import cn.edu.gdmec.android.refoit.Movie.View.IMovieView;
import cn.edu.gdmec.android.refoit.News.Model.NewsModel;
import cn.edu.gdmec.android.refoit.News.View.FgNewsFragment;

/**
 * Created by Administrator on 2018/5/23.
 */

public class MoviePresenter implements IMoviePresenter,IOnMovieListener {
    IMovieModel iMovieModel;
    IMovieView iMovieView;

    public MoviePresenter(IMovieView iMovieView) {
        this.iMovieView = iMovieView;
        this.iMovieModel = new MovieModel();
    }

    @Override
    public void success(MovieBean movieBean) {
        iMovieView.hideDialog();
        if (movieBean != null) {
            iMovieView.showMovie(movieBean);
        }
    }

    @Override
    public void fail(String error) {
        iMovieView.hideDialog();
        iMovieView.showErrorMsg(error);
    }


    @Override
    public void loadMovie(String total) {
        iMovieView.showDialog();
        iMovieModel.loadMovie(total,this);
    }
}
