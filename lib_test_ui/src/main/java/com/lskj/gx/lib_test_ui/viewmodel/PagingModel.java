package com.lskj.gx.lib_test_ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.lskj.gx.lib_business_db.dao.UserDao;
import com.lskj.gx.lib_business_db.entity.UserEntity;

/**
 * 创建时间:  2020/9/7
 * 编写人: tzw
 * 功能描述:
 */
public class PagingModel extends ViewModel {
  private int initPageIndex = 0;
  private int initPageSize = 20;
  private final String TAG = PagingModel.class.getSimpleName();
  private LiveData<PagedList<UserEntity>> lvUsers;
  private PagedList.Config config = new PagedList.Config.Builder().setEnablePlaceholders(true)
      .setEnablePlaceholders(true)
      .setEnablePlaceholders(false)
      .setPageSize(initPageSize)
      .setPrefetchDistance(2)
      .build();

  //public PagingDataSource getDataSource() {
  //  return dataSource;
  //}

  public MutableLiveData<Boolean> getBoundaryData() {
    return boundaryData;
  }

  //是否有数据
  private MutableLiveData<Boolean> boundaryData = new MutableLiveData<>();
  //private DataSource.Factory mFactory = new DataSource.Factory<Integer, UserVo>() {
  //
  //  @NonNull @Override public DataSource<Integer, UserVo> create() {
  //    dataSource = new PagingDataSource();
  //    return dataSource;
  //  }
  //};

  private PagedList.BoundaryCallback<UserEntity> boundary = new PagedList.BoundaryCallback<UserEntity>() {
    @Override public void onZeroItemsLoaded() {
      super.onZeroItemsLoaded();
      //初始化数据
      //boundaryData.postValue(false);
      System.out.println("onZeroItemsLoaded");
    }

    @Override public void onItemAtFrontLoaded(@NonNull UserEntity itemAtFront) {
      super.onItemAtFrontLoaded(itemAtFront);
      //正在添加数据
      //boundaryData.postValue(true);
      System.out.println("onItemAtFrontLoaded");
    }

    @Override public void onItemAtEndLoaded(@NonNull UserEntity itemAtEnd) {
      super.onItemAtEndLoaded(itemAtEnd);
      //没有数据加载了
      //boundaryData.postValue(false);
      System.out.println("onItemAtEndLoaded");
    }
  };

  public LiveData<PagedList<UserEntity>> loadLiveData(UserDao userDao) {
    lvUsers =
        new LivePagedListBuilder<Integer, UserEntity>(userDao.lvDataFactory(), config).setBoundaryCallback(boundary)
            .build();
    return lvUsers;
  }

  //public void loadData(int pageIndex, PageKeyedDataSource.LoadInitialCallback<Integer, UserVo> initCallBack,
  //    PageKeyedDataSource.LoadCallback<Integer, UserVo> loadCallBack) {
  //  if (mRoomDbManger == null) {
  //    mRoomDbManger = RoomDbHelper.getInstance();
  //  }
  //  if (userDao == null) {
  //    userDao = mRoomDbManger.getUserDao();
  //  }
  //  List<UserEntity> userEs = userDao.queryUsers2(pageIndex, initPageSize);
  //  ArrayList<UserVo> datas = new ArrayList<>();
  //  if (userEs != null) {
  //    for (int i = 0; i < userEs.size(); i++) {
  //      UserVo userVo = PojoConvertUtil.convertPojo(userEs.get(i), UserVo.class);
  //      datas.add(userVo);
  //    }
  //  }
  //  if (initCallBack != null) {
  //    //if (pageIndex == initPageIndex && datas.size() == 0) {
  //    initCallBack.onResult(datas, pageIndex, pageIndex + 1);
  //    //} else {
  //    //  initCallBack.onResult(datas, pageIndex, pageIndex + 1);
  //    //}
  //  } else {
  //    //if (pageIndex != initPageIndex && datas.size() == 0) {
  //    //  //没有更多数据的时候给
  //    //  loadCallBack.onResult(datas, null);
  //    //} else {
  //    loadCallBack.onResult(datas, pageIndex + 1);
  //    //}
  //  }
  //  //这个待会
  //  boundaryData.postValue(datas.size() <= 0);
  //}

  //class PagingDataSource extends PageKeyedDataSource<Integer, UserVo> {
  //
  //  @Override public void loadInitial(@NonNull LoadInitialParams<Integer> params,
  //      @NonNull LoadInitialCallback<Integer, UserVo> callback) {
  //    loadData(initPageIndex, callback, null);
  //    Timber.tag(TAG).e("loadInitial  pageIndex 0");
  //  }
  //
  //  @Override
  //  public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, UserVo> callback) {
  //    //刷新的请求交给smart refresh layout处理这里只要是上滑就会触发
  //  }
  //
  //  @Override
  //  public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, UserVo> callback) {
  //    loadData(params.key, null, callback);
  //    Timber.e("loadAfter pageIndex " + params.key);
  //  }
  //}
}
