# retrofit大总结 #
1. Retrofit 将描述请求的接口转换为对象，然后再由该对象去请求后台。Retrofit 将请求对象化了。
2. 利用注解的方式标记参数，将 HTTP 的请求方法，请求头，请求参数，请求体等等都用注解的方式标记，使用起来非常方便。
3. 直接将 Http 的 Response 转换成对象。用户可以根据 Response 的具体内容，更换转换器，或者自己新建转化器。
4. Retrofit 默认使用 OkHttp 开源库请求后台，用户也可以使用自定义的具体请求方式。方便扩展。
5. 自带提供了异步处理 Http 请求的方式。

----------
## retrofit原理分析 ##
- 从retrofit.create的方法中可以看到，主要采用动态代理技术，通过Proxy.newProxyInstance方法中的InvocationHandler对象，它的invoke方法会传入参数，然后通过java反射技术得到ServiceMethod，ServiceMethod就像是一个中央处理器，传入Retrofit对象和Method对象，调用各个接口和解析器，最终生成一个Request返回了一个call对象，默认使用okhttp3作为作为底层的http请求。
## retrofit源码分析 ##
- retrofit2.http包，里面全部是定义HTTP请求的Java注解，比如GET、POST、PUT、DELETE、Headers、Path、Query等等
- Retrofit的设计非常插件化而且轻量级，真的是非常高内聚而且低耦合，这个和它的接口设计有关
- Callback<T>这个接口就是retrofit请求数据返回的接口，只有两个方法void onResponse(Response<T> response);void onFailure(Throwable t)
- Converter<F, T>这个接口主要的作用就是将HTTP返回的数据解析成Java对象，比如Gson
- Call<T>这个接口主要的作用就是发送一个HTTP请求，Retrofit默认的实现是OkHttpCall<T>
- CallAdapter<T>上CallAdapter中属性只有responseType一个，还有一个<R> T adapt(Call<R> call)方法，这个接口的实现类也只有一个，DefaultCallAdapter。这个方法的主要作用就是将Call对象转换成另一个对象，可能是为了支持RxJava才设计这个类的吧
- ## retrofit运行过程 ##
- 







