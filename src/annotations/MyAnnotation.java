package annotations;

import java.lang.annotation.*;
                                                    // argumenty adnotacji uzupełniają jej elementy (analogi dla pól w klasach),
                                                    // gdy elementów adnotacji jest kilka, konieczne jest zastosowanie zapisu
// Tworzenie własnej adnotacji:                     // @Adnotacja(element1=..., element2=...)
@Target({ ElementType.TYPE, ElementType.METHOD })   // @Target definiuje w jakim kontekście ("przed czym") można użyć adnotacji
@Retention(RetentionPolicy.RUNTIME)                 // @Retention definiuje czas przechowywania danych o adnotacji (...)
public @interface MyAnnotation {
    String author() default "Kuba";                 // author to element adnotacji, wartość domyślna jest podana
}

// Teraz mogę używać adnotacji: @MyAnnotation(author="Kuba"), @MyAnnotation("Kuba") lub @MyAnnotation z identycznym skutkiem