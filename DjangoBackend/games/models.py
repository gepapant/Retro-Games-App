from django.db import models


class Game(models.Model):

    title = models.CharField(max_length=255)

    platform = models.CharField(max_length=100)

    release_date = models.DateField()

    description = models.TextField(blank=True)

    image_url = models.URLField(blank=True)

    youtube_url = models.URLField(blank=True)

    def __str__(self):
        return self.title
