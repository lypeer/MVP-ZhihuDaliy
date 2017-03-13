<?xml version="1.0"?>
<recipe>
    <instantiate from="root/src/app_package/SimpleDataSource.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/${name}DataSource.java" />

    <instantiate from="root/src/app_package/SimpleRepository.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/${name}Repository.java" />

    <instantiate from="root/src/app_package/SimpleLocalDS.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/local/${name}LocalDS.java" />

    <instantiate from="root/src/app_package/SimpleRemoteDS.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/remote/${name}RemoteDS.java" />
 </recipe>
