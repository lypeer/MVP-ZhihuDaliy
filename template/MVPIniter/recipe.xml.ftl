<?xml version="1.0"?>
<recipe>
    <!--api package-->
    <#if useRetrofit>
    <instantiate from="root/src/app_package/api/ApiService.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/api/ApiService.java" />
    </#if>

    <instantiate from="root/src/app_package/api/OnItemClickListener.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/api/OnItemClickListener.java" />

    <instantiate from="root/src/app_package/api/OnResultCallback.java.ftl"                    
                    to="${escapeXmlAttribute(srcOut)}/api/OnResultCallback.java" />


    <!--event package-->
    <#if useEventBus>
    <instantiate from="root/src/app_package/event/EmptyEvent.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/event/EmptyEvent.java" />
    </#if>

    <!--framework package-->
    <instantiate from="root/src/app_package/framework/BaseActivity.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/framework/BaseActivity.java" />
    
    <instantiate from="root/src/app_package/framework/BaseAdapter.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/framework/BaseAdapter.java" />

    <#if useEventBus>
    <instantiate from="root/src/app_package/framework/BaseBusView.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/framework/BaseBusView.java" />
    </#if>
 
    <instantiate from="root/src/app_package/framework/BaseCustomActivity.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/framework/BaseCustomActivity.java" />

    <instantiate from="root/src/app_package/framework/BaseCustomFragment.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/framework/BaseCustomFragment.java" />

    <instantiate from="root/src/app_package/framework/BaseFragment.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/framework/BaseFragment.java" />

    <instantiate from="root/src/app_package/framework/BasePresenter.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/framework/BasePresenter.java" />

    <instantiate from="root/src/app_package/framework/BasePresenterApi.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/framework/BasePresenterApi.java" />

    <instantiate from="root/src/app_package/framework/BaseRepository.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/framework/BaseRepository.java" />

    <instantiate from="root/src/app_package/framework/BaseView.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/framework/BaseView.java" />

    <instantiate from="root/src/app_package/framework/BaseViewApi.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/framework/BaseViewApi.java" />

    <instantiate from="root/src/app_package/framework/BaseViewHolder.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/framework/BaseViewHolder.java" />

    <!--util package-->
    <instantiate from="root/src/app_package/utils/ActivityController.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/utils/ActivityController.java" />

    <instantiate from="root/src/app_package/utils/BaseUtil.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/utils/BaseUtil.java" />

    <instantiate from="root/src/app_package/utils/Constants.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/utils/Constants.java" />

    <instantiate from="root/src/app_package/utils/Injection.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/utils/Injection.java" />

    <!--model package-->
    <instantiate from="root/src/app_package/model/BaseResponse.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/model/BaseResponse.java" />

    <#if useRetrofit>
    <instantiate from="root/src/app_package/model/RetrofitClient.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/model/RetrofitClient.java" />
    </#if>

    <!--app-->
    <instantiate from="root/src/app_package/App.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/App.java" />

 </recipe>
