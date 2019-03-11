package ocr.codeyourlife.com.ocrapp_android.di;

import dagger.Component;
import dagger.Module;
import ocr.codeyourlife.com.ocrapp_android.service.NetworkModule;
import ocr.codeyourlife.com.ocrapp_android.view.MainActivity;

import javax.inject.Singleton;

@Singleton
@Component(modules = NetworkModule.class)
public interface OCRComponent {
    void inject(MainActivity homeActivity);

}
