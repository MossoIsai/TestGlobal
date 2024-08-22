# Test
## Clean architecture
Este proyecto utiliza clean architecture + MVVM 
![0_mwVSPyoOCFtSufKh](https://github.com/MossoIsai/Movies/assets/8402737/d78b2b9d-b8f1-4ff7-969d-755bdb3fa13e)

Agrega tu Access Api Key de TMDB aquí
```sh
Bearer ${TU_ACCESS_API_KEY}

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {

        val httpLoginInterceptor = HttpLoggingInterceptor()
        httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY


        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoginInterceptor).addInterceptor { chain ->
                val request =
                    chain.request().newBuilder()
                        .addHeader(
                            "Authorization",
                            "Bearer ${BuildConfig.MY_ACCESS_API_KEY}" //cambia esto por tu Access Api Key
                        )
                        .build()
                chain.proceed(request)
            }.build()
    }
```



En la capa de presentación esta todo lo relacionado a la ui y algunos otros elementos que se consideran de presentación

```sh
 - Presentation
   - ui
   - uistate
   - viewmodel
   - di
   - extesions
```
La capa de dominio es responsable de encapsular la lógica empresarial compleja o la lógica empresarial simple que es reutilizada por múltiples ViewModels.
```sh
 - domain
   - usecase
   - repository(interface)
   - entities
   - mappings(convierte modelos de data a dominio)
```
La capa de datos contiene datos de aplicación y lógica empresarial. La lógica de negocios es lo que le da valor a su aplicación: está compuesta de reglas comerciales del mundo real que determinan cómo se deben crear, almacenar y cambiar los datos de la aplicación.
```sh
 - data
   - repository(implementación)
   - api(endpoints)
   - models
   - resource ->

             - local (database, SharedPreferences, DataStore, ProtoDataStore)
             - remote (web service, Firebase etc.)
```
## Movie List
![Screenshot_20240822_093952](https://github.com/user-attachments/assets/482973de-1832-41d8-b8b1-64661f9b4a91)





