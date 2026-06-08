from django.contrib import admin

from django.urls import path, include
from games.auth import login

urlpatterns = [

    path(
        'admin/',
        admin.site.urls
    ),

    path(
        'api/',
        include('games.urls')
    ),

    path('api/login/', login),
]
