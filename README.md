Sobre
=====
O GDG Pros And Cons é uma aplicação web/mobile para que seja mais efetiva a captação de feedback em tempo real dos encontros mensais do GDG-Sp.
Este repositório contém a implementação do *aplicativo* GDG Pros And Cons.
[Meetup GDG-Sp](http://www.meetup.com/GDG-SP/)
[Repositório app Android](https://github.com/cirocosta/gdg-pros-and-cons-android)

Dependências
===========
[Volley](https://developers.google.com/events/io/sessions/325304728) : *Networking & Simple image loading*
[GSON](https://code.google.com/p/google-gson/) : *POJOs <- -> Json*
[G. Play Services](http://developer.android.com/google/play-services/index.html) : [GCM](http://developer.android.com/google/gcm/index.html)
[V7-AppCompat](https://developer.android.com/tools/support-library/features.html#v7-appcompat) : Support library para ActionBar 

External
============
Faz-se uso da API do [Meetup.com](www.meetup.com) para a obtenção de dados referentes aos encontros do grupo:

- https://api.meetup.com/2/groups?&sign=true&group_urlname=GDG-SP&page=20
- https://api.meetup.com/2/events?&sign=true&group_id=8562442&page=20
