## IDEA 项目路径配置-防止Servlet配置路径无效
1. 服务器Tomcat中配置，Deployment->Application context设置为发布项目名称
2. 项目配置（Project structure）中,facets->Web Resource Directories -> Path Relative to Deployment Root中配置为"/"

## Servlet 3.0以后注解配置无效
要注意在web.xml中，当metadata-complete="true"时，注解配置的Servlet将不会被读取解析