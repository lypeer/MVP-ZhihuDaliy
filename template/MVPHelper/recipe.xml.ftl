<?xml version="1.0"?>
<recipe>
    <instantiate from="root/src/app_package/SimpleContract.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/${name}Contract.java" />

    <instantiate from="root/src/app_package/SimplePresenter.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/${name}Presenter.java" />

    <instantiate from="root/src/app_package/SimpleView.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/${name}View.java" />

    <instantiate from="root/src/app_package/SimpleActivity.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/${name}Activity.java" />

    <#if hasAdapterAndVH>
    	<instantiate from="root/src/app_package/SimpleAdapter.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/${name}Adapter.java" />
        <instantiate from="root/src/app_package/SimpleVH.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/${name}VH.java" />
    </#if>
 </recipe>
