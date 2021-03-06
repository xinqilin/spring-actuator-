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
	<td>若是true時，可發/shutdown 的post req去關閉server</td>
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

### 配置path
```
management.endpoints.web.basePath=
```

### 全部啟用 management.endpoints.enabled-by-default

```
management.endpoints.enabled-by-default=true
```

全部停用，只啟用部分

```
management.endpoints.enabled-by-default=false
management.endpoint.[id].enabled=true
```
### 開放與封閉
```
management.endpoints.<web|jmx>.exposure.<include|exclude>

 * 開放所有所有web端點，如果暴露的是一個要用 id 並以逗號隔開 
management.endpoints.web.exposure.include='*'

排除端點
management.endpoints.web.exposure.exclude=
```

### 安全性
```
可用上面方法  或是 此方法關閉敏感端點 ex: /shutdown 或是使用Spring security 來搭配使用
management.server.port=-1
```

### 自訂義 (boot 2 開始，Actuator支援CRUD模型)

@Endpoint 支援JMX和http
@JmxEndpoint 只支援JMX
@WebEndpoint 只支援http

通過在一個端點類（必須是Spring Bean）上添加上面其中一個來表明該類是一個端點類。
在類的方法使用
@ReadOperation
@WriteOperation
@DeleteOperation，這分別會orm到Http中的GET，POST，DELETE。以下範例

```

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

       // getters and setters ...
   }

}

```

### 應用延伸
可以使用
@EndpointExtension
@EndpointWebExtension
@EndpointJmxExtension
來延伸端點行為

```

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

```

### Spring Boot metrics

Spring Boot 2中的執行器對Micrometer的自動配置。
甚至我們可以通過一個叫MeterRegistry的Spring Bean來註冊一個自定義的metric指標。
也可以通過/ actuator / metrics / {metricName}來獲取具體尺寸的元數據。
Micrometer是一個應用指標門麵類庫，類似SLF4。


------------------------------------------------------

### 前期找的資料，供參考
management.endpoint.[id].enabled 配置是否啟用

### 更換用法 boot 1.5.x => boot 2

- 啟用端點 env
management.endpoint.env.enabled=true

- 暴露端點 env 配置多個,隔開
management.endpoints.web.exposure.include=env

- 開啟全部
management.endpoint.*.enabled=true
management.endpoints.web.exposure.include=*
