from rest_framework import viewsets, filters
from django_filters.rest_framework import DjangoFilterBackend

from .models import Game
from .serializers import GameSerializer


class GameViewSet(viewsets.ModelViewSet):

    queryset = Game.objects.all()

    serializer_class = GameSerializer

    filter_backends = [
        DjangoFilterBackend,
        filters.SearchFilter
    ]

    filterset_fields = {
        'release_date': ['gte', 'lte'],
    }

    search_fields = [
        'title',
        'platform'
    ]
