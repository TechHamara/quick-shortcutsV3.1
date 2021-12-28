package com.memelabs.quickshortcuts;

import android.os.Build;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.AssetManager;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.YailList;

import java.util.Arrays;
import java.util.List;

public class QuickShortcuts extends AndroidNonvisibleComponent {

  public Activity activity;
  public Context context;
  public Intent intent;
  public Icon icon;

  // Compatibility with API 25+ (Android 7.0), safeguard implemented so that it doesn't crash on older versions of Android
  public Boolean compatibility = android.os.Build.VERSION.SDK_INT >= 26;

  public QuickShortcuts(ComponentContainer container) {
    super(container.$form());
    activity = container.$context();
    context = activity;
  }

  @SimpleFunction(description = "Creates a shortcut with the given name, icon, starting screen and value.")
  public void CreateDynamicShortcut(String id ,String shortName, String longName, String icon, String screen, String startValue) {
    if (compatibility) {
      ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
      AssetManager assetManager = context.getAssets();
      String packageName = context.getClass().getPackage().getName();
      Intent shortcutIntent;
      ShortcutInfo shortcut;
      try {
        shortcutIntent = new Intent(Intent.ACTION_VIEW, null, context, Class.forName(packageName + "." + screen)).putExtra("APP_INVENTOR_START", startValue);
      } catch (Exception e) {
        throw new YailRuntimeError(e.toString(), "Exception");
      }

      try {
        shortcut = new ShortcutInfo.Builder(context, id)
          .setShortLabel(shortName)
          .setLongLabel(longName)
          .setIcon(Icon.createWithBitmap(BitmapFactory.decodeStream(assetManager.open(icon))))
          .setIntent(shortcutIntent)
          .build();
      } catch (Exception e) {
        throw new YailRuntimeError(e.toString(), "IOException");
      }

      shortcutManager.pushDynamicShortcut(shortcut);
    }
  }

  @SimpleFunction(description = "Creates and requests to pin a shortcut with the given name, icon, starting screen and value.")
  public void CreatePinnedShortcut(String id ,String shortName, String longName, String icon, String screen, String startValue) {
    if (compatibility) {
      ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
      AssetManager assetManager = context.getAssets();
      String packageName = context.getClass().getPackage().getName();
      Intent shortcutIntent;
      ShortcutInfo shortcut;
      try {
        shortcutIntent = new Intent(Intent.ACTION_VIEW, null, context, Class.forName(packageName + "." + screen)).putExtra("APP_INVENTOR_START", startValue);
      } catch (Exception e) {
        throw new YailRuntimeError(e.toString(), "Exception");
      }

      try {
        shortcut = new ShortcutInfo.Builder(context, id)
          .setShortLabel(shortName)
          .setLongLabel(longName)
          .setIcon(Icon.createWithBitmap(BitmapFactory.decodeStream(assetManager.open(icon))))
          .setIntent(shortcutIntent)
          .build();
      } catch (Exception e) {
        throw new YailRuntimeError(e.toString(), "IOException");
      }

      shortcutManager.requestPinShortcut(shortcut, null);
    }
  }

  @SimpleFunction(description = "Removes the shortcut with the given id.")
  public void RemoveShortcut(String id) {
    if (compatibility) {
      ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
      shortcutManager.removeDynamicShortcuts(Arrays.asList(id));
    }
  }

  @SimpleFunction(description = "Disable a shortcut with the given id.")
  public void DisableShortcut(String id) {
    if (compatibility) {
      ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
      shortcutManager.disableShortcuts(Arrays.asList(id));
    }
  }

  @SimpleFunction(description = "Enable a shortcut with the given id.")
  public void EnableShortcut(String id) {
    if (compatibility) {
      ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
      shortcutManager.enableShortcuts(Arrays.asList(id));
    }
  }

  @SimpleFunction(description = "Removes all dynamic shortcuts.")
  public void RemoveAllDynamicShortcuts() {
    if (compatibility) {
      ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
      shortcutManager.removeAllDynamicShortcuts();
    }
  }

  @SimpleFunction(description = "Checks whether a dynamic shortcut exists by id.")
  public boolean IsDynamicShortcutExist(String id) {
    if (compatibility) {
      ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
      List<ShortcutInfo> shortcutsList = shortcutManager.getShortcuts(2);
      for (int i = 0; i < shortcutsList.size(); i++) {
        if (shortcutsList.get(i).getId().equals(id)) {
          return true;
        }
      }
      return false;
    } else {
      return false;
    }
  }

  @SimpleFunction(description = "Checks whether a pinned shortcut exists by id.")
  public boolean IsPinnedShortcutExist(String id) {
    if (compatibility) {
      ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
      List<ShortcutInfo> shortcutsList = shortcutManager.getShortcuts(4);
      for (int i = 0; i < shortcutsList.size(); i++) {
        if (shortcutsList.get(i).getId().equals(id)) {
          return true;
        }
      }
      return false;
    } else {
      return false;
    }
  }

  @SimpleFunction(description = "Checks if creating shortcuts is rate-limited by the user's device.") 
  public boolean IsRateLimited() {
    if (compatibility) {
      ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
      return shortcutManager.isRateLimitingActive();
    } else {
      return false;
    }
  }

  @SimpleFunction(description = "Checks if the device supports shortcuts (SDK => 25 or higher).")
  public boolean IsShortcutsSupported() {
    return compatibility;
  }

  @SimpleFunction(description = "Checks whether the user's launcher supports pinning shortcuts.")
  public boolean IsPinnedShortcutsSupported() {
    if (compatibility) {
      ShortcutManager shortcutManager = context.getSystemService(ShortcutManager.class);
      return shortcutManager.isRequestPinShortcutSupported();
    } else {
      return false;
    }
  }
}
