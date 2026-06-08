from rest_framework import viewsets

from .models import Game

from .serializers import GameSerializer


class GameViewSet(viewsets.ModelViewSet):

    queryset = Game.objects.all()

    serializer_class = GameSerializer

    def get_queryset(self):

        queryset = Game.objects.all()

        title = self.request.GET.get('title')

        date_from = self.request.GET.get('dateFrom')

        date_to = self.request.GET.get('dateTo')

        if title:
            queryset = queryset.filter(
                title__icontains=title
            )

        if date_from:
            queryset = queryset.filter(
                release_date__gte=date_from
            )

        if date_to:
            queryset = queryset.filter(
                release_date__lte=date_to
            )

        return queryset
