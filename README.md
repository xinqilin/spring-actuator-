# spring-actuator

spring boot  and actuator


### Actuator 提供了 13 個接口，具體如下表所示 (引用自think power)<a href="https://tpu.thinkpower.com.tw/tpu/articleDetails/954">think power</a>
<table cellpadding="8" border="1">
	<tr>
		<th>路徑</th>
		<th>描述</th>
	</tr>
	<tr>
		<th>/health</th>
		<th>展示系統的各種組件運行狀態、硬碟使用狀況</th>
	</tr>
	<tr>
		<th>/metrics</th>
		<th>統計系統當前的一些即時信息，如：該系統接收了多少個請求、cache命中率、mq中有多少條信息待處理、CPU使用率、內存占用情況等。</th>
	</tr>
	<tr>
		<th>/metrics/{name}</th>
		<th>報告指定名稱的應用進程度量值</th>
	</tr>
	<tr>
		<th>/dump</th>
		<th>當前系統中線程的詳細信息</th>
	</tr>
	<tr>
		<th>/env</th>
		<th>展示系統變量 和 springboot的應用變量</th>
	</tr>
	<tr>
		<th>/env/{name}</th>
		<th>根據名稱獲取特定的環境屬性值</th>
	</tr>
	<tr>
		<th>/trace</th>
		<th>顯示最近的http請求的request、response對（默認最多緩存100條）</th>
	</tr>
	<tr>
		<th>/autoconfig</th>
		<th>展示所有auto-configuration候選者及它們被應用或未被應用的原因</th>
	</tr>
	<tr>
		<th>/info</th>
		<th>顯示應用自定義的信息：如該應用的聯繫人、名稱、版本等</th>
	</tr>
	<tr>
		<th>/configprops</th>
		<th>顯示所有被@ConfigurationProperties mark的Bean的信息列表</th>
	</tr>
	<tr>
		<th>/mappings</th>
		<th>顯示所有@RequestMapping mark 的url list</th>
	</tr>
	<tr>
		<th>/shutdown</th>
		<th>允許以POST方式關閉應用，要求endpoints.shutdown.enabled設置為true</th>
	</tr>
	<tr>
		<th>/beans</th>
		<th>顯示該應用中所有Spring Beans的完整信息，包括依賴了哪些bean、是singleton還是prototype</th>
	</tr>

</table>


## spring boot 2參考用表
<table cellpadding="5" border="1">
<tr>
	<th>id</th>
	<th>效果</th>
	<th>default value</th>
</tr>
<tr>
	<td>auditevents</td>
	<td>顯示當前訊息事件</td>
	<td>Y</td>
</tr>
<tr>
	<td>beans</td>
	<td>顯示應用Spring Beans的完整列表</td>
	<td>Y</td>
</tr>
<tr>
	<td>caches</td>
	<td>顯示可cache訊息</td>
	<td>Y</td>
</tr>
<tr>
	<td>conditions</td>
	<td>顯示autoconfig 的狀態與應用訊息</td>
	<td>Y</td>
</tr>

<tr>
	<td>configprops</td>
	<td>顯示所有@ConfigurationProperties 列表</td>
	<td>Y</td>
</tr>
<tr>
	<td>env</td>
	<td>顯示ConfigurableEnvironment 中的属性</td>
	<td>Y</td>
</tr>
<tr>
	<td>flyway</td>
	<td>顯示Flyway 中data遷移訊息</td>
	<td>Y</td>
</tr>
<tr>
	<td>health</td>
	<td>顯示應運的訊息(為認證只顯示status，已認證顯示全部)</td>
	<td>Y</td>
</tr>

<tr>
	<td>info</td>
	<td>很直白</td>
	<td>Y</td>
</tr>
<tr>
	<td>liquibase</td>
	<td>跟fly依樣，顯示liquibase</td>
	<td>Y</td>
</tr>
<tr>
	<td>metrics</td>
	<td>顯示當前metrics訊息</td>
	<td>Y</td>
</tr>


<tr>
	<td>mappings</td>
	<td>顯示所有@RequestMapping</td>
	<td>Y</td>
</tr>
<tr>
	<td>scheduledtasks</td>
	<td>顯示所有scheduledtasks</td>
	<td>Y</td>
</tr>

<tr>
	<td>sessions</td>
	<td>...</td>
	<td>Y</td>
</tr>
<tr>
	<td>shutdown</td>
	<td></td>
	<td style="color:red;">N</td>
</tr>
<tr>
	<td>threaddump</td>
	<td>執行一個thread的dump</td>
	<td>Y</td>
</tr>
<tr>
	<td>httptrace</td>
	<td>顯示最後執行的100的http req</td>
	<td>Y</td>
</tr>
<tr>
	<td>heapdump</td>
	<td>return gzip 的dump文件</td>
	<td>Y</td>
</tr>

<tr>
	<td>prometheus</td>
	<td>Prometheus的格式顯示metrics訊息</td>
	<td>Y</td>
</tr>
</table>

參考掘金https://juejin.im/post/5d78afa951882505e029c57e
未整理

```
3.1 启用与关闭
默认情况下除了shutdown是关闭的其它端点都是启用的。个别端点的启用依赖其他组件，比如我们上篇文章介绍的Prometheus。我们可以在Spring Boot 配置文件中通过配置（id参见上表）management.endpoint.<id>.enabled来配置端点是否启用。
另外我们可以通过management.endpoints.enabled-by-default来修改全局端口默认配置,以下示例启用info端点并禁用所有其他端点：
# 先设置所有的端点默认为关闭
management.endpoints.enabled-by-default=false
# 然后开启info 端点
management.endpoint.info.enabled=true
复制代码3.2 开放与封闭
特别需要我们注意的是，以上只是我们开启的端点功能，并不意味我们把这些端点暴露给应用之外的环境中去。暴露的配置规则是 management.endpoints.<web|jmx>.exposure.<include|exclude>我们以web为例，通过以下方式来暴露web端点：
#  * 为暴露所有web端点，如果暴露的是一个列表请使用端点 id 并以逗号隔开 
management.endpoints.web.exposure.include='*'
复制代码同样的如果我们要排除一些web端点请用 management.endpoints.web.exposure.exclude来配置。我们可以通过/actuator来列举暴露的端点。当然这个路径取决于我们对management.endpoints.web.basePath的配置。
3.3 安全性
对于生产环境来说端点都是敏感的。我们当然不希望非法的访问端点，特别如/shutdown这种端点。我们可以通过上面3.1、3.2进行关闭、封闭操作。也可直接配置management.server.port=-1 来关闭管理端点。或者确保在外面的安全框架诸如Spring security的控制之下。即保证 EndpointRequest.toAnyEndpoint()的安全性。
3.4 自定义端点
Spring Boot 2.x 开始，Actuator支持CRUD模型，而不是旧的RW（读/写）模型。我们可以按照两种策略来自定义：

@Endpoint 同时支持JMX和http
@JmxEndpoint 只支持JMX技术
@WebEndpoint 只支持http

通过在一个端点类（必须是Spring Bean）上添加上面其中一个来表明该类是一个端点类。
在类的方法使用@ReadOperation，@WriteOperation或@DeleteOperation，这分别会映射到Http中的 GET、POST、DELETE（对http来说）。  以下是我们自定义的一个端点：

@Component
@Endpoint(id = "features")
public class FeaturesEndpoint {

   private Map<String, Feature> features = new ConcurrentHashMap<>();

   @ReadOperation
   public Map<String, Feature> features() {
       return features;
   }

   @ReadOperation
   public Feature feature(@Selector String name) {
       return features.get(name);
   }

   @WriteOperation
   public void configureFeature(@Selector String name, Feature feature) {
       features.put(name, feature);
   }

   @DeleteOperation
   public void deleteFeature(@Selector String name) {
       features.remove(name);
   }

   public static class Feature {
       private Boolean enabled;

       // [...] getters and setters 
   }

}
复制代码注意请务必保证端点的id在该应用中唯一。
3.5 端点扩展
假设我们想要确保我们的应用程序的生产实例永远不是SNAPSHOT版本。我们决定通过更改返回此信息的Actuator端点（/info）来完成此操作。如果我们的应用程序恰好是SNAPSHOT。我们将获得不同的HTTP状态代码。
我们可以使用@EndpointExtension或其更具体的@EndpointWebExtension、@EndpointJmxExtension轻松扩展预定义端点的行为：
@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
public class InfoWebEndpointExtension {
 
    private InfoEndpoint delegate;
 
    // standard constructor
 
    @ReadOperation
    public WebEndpointResponse<Map> info() {
        Map<String, Object> info = this.delegate.info();
        Integer status = getStatus(info);
        return new WebEndpointResponse<>(info, status);
    }
 
    private Integer getStatus(Map<String, Object> info) {
        // return 5xx if this is a snapshot
        return 200;
    }
}
复制代码3.6 Spring Boot metrics
运维应用监控依赖于对应用度量（metric）指标的抽取。Spring Boot 2.x中的Actuator 对Micrometer的自动配置。 甚至我们可以通过一个叫MeterRegistry的Spring Bean来注册一个自定义的metric指标。我们可以通过/actuator/metrics端点获取所有的metric指标。 也可以通过/actuator/metrics/{metricName} 来获取具体度量的元数据。
Micrometer 是一个应用度量门面类库，类似SLF4。后面我会专门写一篇文章来介绍这个知识点。请关注我的公众号：Felordcn 以保证第一时间获取相关的知识。

```

### 使用
management.endpoint.[id].enabled 配置是否啟用

### 更換用法 boot 1.5.x => boot 2

- 啟用端點 env
management.endpoint.env.enabled=true

- 暴露端點 env 配置多個,隔開
management.endpoints.web.exposure.include=env

- 開啟全部
management.endpoint.*.enabled=true
management.endpoints.web.exposure.include=*
