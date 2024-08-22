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
Agre tu Google Map Api Key aquí
```sh
 <meta-data
            android:name="com.google.android.maps.v2.API_KEY"
            android:value="@string/TU_MAP_API_KEY"/>
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
## Profile

![Screenshot_20240406_211446](https://github.com/MossoIsai/Movies/assets/8402737/4f274e3c-b8c2-456b-9b41-df62838537d2)


## Movies List Populars

![Screenshot_20240403_194347](https://github.com/MossoIsai/Movies/assets/8402737/c699a5f4-46b4-4f91-ae3e-c74eac235476)

## Mapa
Mapa con las coordenadas del usuario levantadas cada 5 minutos con un serivicio de ubicación ejecutandose en segundo plano y almacenadas de manera local(Room)

![Screenshot_20240408_012026](https://github.com/MossoIsai/Movies/assets/8402737/1465980f-8220-4426-9a90-9beb2578a68a)

## Notificación con la ubicación actualizada cada 5 minutos

![NOTIFICACION](https://github.com/MossoIsai/Movies/assets/8402737/badec5af-bb71-433a-ba04-15d947c31a86)



## observaciones
Durante el desarrollo me encontre con un bug que hace que la aplicación crashea en la sección del mapa esto por el servicio en location y esto ocurre en <b>Android 14</b>

<img width="1495" alt="Captura de pantalla 2024-04-06 a la(s) 22 37 37" src="https://github.com/MossoIsai/Movies/assets/8402737/8222b35b-adb7-492b-88b1-43d4535258d4">

https://issuetracker.google.com/issues/294804418



