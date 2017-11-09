Struts2对ModelDriven模式的支持

Struts2可以采用类似于Struts1中的ActionForm方式手机数据，这样方式叫ModelDriven模式

如何实现模型驱动模式？
	*创建User
	*Action需要实现ModelDriven接口
	*要实现getModel()方法，返回Bean对象