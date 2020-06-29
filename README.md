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