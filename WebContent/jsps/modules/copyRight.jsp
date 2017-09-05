<%@ page contentType="text/html;charset=utf-8"%>

		<div id="foot">
			<div id="friendship_link">
				<div id="flink_title">友情链接</div>
				<div id="flink_1">
					<div class="linktitle">政府链接</div>
					<div class="linkselect">
						<select onchange="if(this.options[this.selectedIndex].value!='')window.open(this.options[this.selectedIndex].value)">
							<c:forEach var="link" items="${map.link_1}">
								<option value="${link.address}">${link.names}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div id="flink_2">
					<div class="linktitle">企业链接</div>
					<div class="linkselect">
						<select onchange="if(this.options[this.selectedIndex].value!='')window.open(this.options[this.selectedIndex].value)">
							<c:forEach var="link" items="${map.link_2}">
								<option value="${link.address}">${link.names}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div id="flink_3">
					<div class="linktitle">媒体链接</div>
					<div class="linkselect">
						<select onchange="if(this.options[this.selectedIndex].value!='')window.open(this.options[this.selectedIndex].value)">
							<c:forEach var="link" items="${map.link_3}">
								<option value="${link.address}">${link.names}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div id="foot_info">
				${webSite.copyright}
			</div>
		</div>
	</body>
</html>