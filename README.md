GDG ProsAndCons
======
Sobre
------
O GDG Pros And Cons é uma aplicação web/mobile para que seja mais efetiva a captação de feedback em tempo real dos encontros mensais do GDG-Sp.
Este repositório contém a implementação do *aplicativo* GDG Pros And Cons.
[Meetup GDG-Sp](http://www.meetup.com/GDG-SP/)
[Repositório app Android](https://github.com/cirocosta/gdg-pros-and-cons-android)

Dependências
------

- [Crouton](https://github.com/keyboardsurfer/Crouton) : *Toast-a-like* com consistência e manuseabilidade de cancel
- [Volley](https://developers.google.com/events/io/sessions/325304728) : *Networking & Simple image loading*
- [GSON](https://code.google.com/p/google-gson/) : *POJOs <- -> Json*
- [G. Play Services](http://developer.android.com/google/play-services/index.html) : [GCM](http://developer.android.com/google/gcm/index.html), [Maps](https://developers.google.com/maps/documentation/android/), [+ Sign in & Like](https://developers.google.com/+/mobile/android/)
- [V7-AppCompat](https://developer.android.com/tools/support-library/features.html#v7-appcompat) : Support library para ActionBar 

External
------
Faz-se uso da API do [Meetup.com](www.meetup.com) para a obtenção de dados referentes aos encontros do grupo:
Large
- https://api.meetup.com/2/groups?&sign=true&group_urlname=GDG-SP&page=20
- https://api.meetup.com/2/events?&sign=true&group_id=8562442&page=20

Testes
-----
- Testes unitários a serem feitos com a plataforma padrão Android+JUnit;
- Testes de UI inicialmente serão realizados utilizando como framework o [Espresso](https://code.google.com/p/android-test-kit/).
- MonkeyTests para testar ANR/crashes por stress-test.

*as stated on [How the Google+ Team Tests Mobile Apps](http://googletesting.blogspot.com.br/2013/08/how-google-team-tests-mobile-apps.html)* 


Disclaimer
------
É encorajada a participação de toda a comunidade sob forma de crítica, sugestão e quaisquer outras formas de contribuição.
Dêem fork, façam pullrequests e ajudem a melhorar o aplicativo que pode ser uma forma de aprendizado para muitos que estão iniciando.

[Desenvolvimento Android Brasil](https://plus.google.com/communities/117285913788478579842)
