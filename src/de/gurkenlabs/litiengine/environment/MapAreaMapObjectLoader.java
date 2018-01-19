package de.gurkenlabs.litiengine.environment;

import de.gurkenlabs.litiengine.entities.IEntity;
import de.gurkenlabs.litiengine.environment.tilemap.IMapObject;
import de.gurkenlabs.litiengine.environment.tilemap.MapArea;
import de.gurkenlabs.litiengine.environment.tilemap.MapObjectType;

public class MapAreaMapObjectLoader extends MapObjectLoader {

  protected MapAreaMapObjectLoader() {
    super(MapObjectType.AREA);
  }

  @Override
  public IEntity load(IMapObject mapObject) {
    if (MapObjectType.get(mapObject.getType()) != MapObjectType.AREA) {
      throw new IllegalArgumentException("Cannot load a mapobject of the type " + mapObject.getType() + " with a loader of the type " + MapAreaMapObjectLoader.class);
    }

    return new MapArea(mapObject.getId(), mapObject.getName(), mapObject.getX(), mapObject.getY(), mapObject.getDimension().width, mapObject.getDimension().height);
  }
}