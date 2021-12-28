# QuickShortcuts
**Backwards compatitble with versions < Android 8 (SDK 26). Features will only work when the user's device is Android => 8 (SDK 26)**

This is a extension that lets you add dynamic shortcuts as well as request user to pin shortcuts to the home screen.

Suggestions and bug reports are suggested as this is my second time dealing with Java and I might not be very experienced at it yet

This is a test release and the blocks included might change before release. If you plan to use it frequently, please think twice before using.

### Gallery
![Screenshot_20211221-153713|250x500, 75%](upload://189EVvYGqgecd39mmET55b1jscT.png) ![Screenshot_20211221-152622|250x500, 75%](upload://6atl0m1uQk4pynJlzGliQ3O3Ket.png)

### Block Documentation

> ![CreateDynamicShortcut|464x184, 75%](upload://cgzxp4RYTfyVHoX3ejt9fz51kR.png)
>
>`CreateDynamicShortcut`
>
>Creates a dynamic shortcut on the app. Users can then access it by holding down your app icon
>
>- id - String
>- shortName - String
>- longName - String
>- icon - String (**Images from app assets only** | Might change in the future)
>- screen - String
>- startValue - String

> ![CreatePinnedShortcut|667x236, 75%](upload://bRpJrkvFArAVaieCyRetXM8DXwv.png)
>
>`CreatePinnedShortcut`
>
>Creates a pinned shortcut on the app and requests the user to place it on the home screen.
>
>- id - String
>- shortName - String
>- longName - String
>- icon - String (**Images from app assets only** | Might change in the future)
>- screen - String
>- startValue - String

> ![RemoveShortcut|341x54, 75%](upload://eEV1EyyZhXq7jEbQB7ok6GhIC4I.png)
>
>`RemoveShortcut`
>
>Removes a dynamic shortcut by id
>
>- id - String

> ![DisableShortcut|335x54, 75%](upload://yvBaIem6kJ8tygrtjOCebsYgXpO.png)
>
>`DisableShortcut`
>
>Disables a shortcut by id
>
>- id - String

> ![EnableShortcut|332x54, 75%](upload://2db752ncXBN5wtLovPdjyfYqXMq.png)
>
>`EnableShortcut`
>
>Enables a shortcut by id
>
>- id - String

> ![RemoveAllDynamicShortcuts|384x29, 75%](upload://tReOgWtPJ6w3DJO7yYhVUVXmmW2.png)
>
>`RemoveAllDynamicShortcuts`
>
>Removes all dynamic shortcuts. Does not apply to pinned shortcuts or dynamic shortcuts that has been pinned to the home screen

> ![IsDynamicShortcutExist|394x50, 75%](upload://nFcO2JGf3k4rs54I6wDNtBFNUod.png)
>
>`IsDynamicShortcutExist`
>
>Checks if a dynamic shortcut exist or not
>
>- id - String
>- Returns - Boolean

> ![IsPinnedShortcutExist|383x50, 75%](upload://9Dhv7AAWKZ1VjVj4CfWhNQtXDXn.png)
>
>`IsPinnedShortcutExist`
>
>Checks if a pinned shortcut exist or not
>
>- id - String
>- Returns - Boolean

> ![IsRateLimited|292x25, 75%](upload://A1JTjemWYu0MNEhzNk1MHu45oNY.png)
>
>`IsRateLimited`
>
>Checks whether the user's device is blocking the app from creating shortcuts due to spam
>
>- Returns - Boolean

> ![IsShortcutsSupported|343x25, 75%](upload://uY8NYLpSLe6Ky6c5p2sEu55jsTg.png)
>
>`IsShortcutsSupported`
>
>Checks whether the the device is supported by the extension (Use this to disable any button if shortcuts is not supported on the user's device.)
>
>- Returns - Boolean

> ![IsPinnedShortcutsSupported|389x25, 75%](upload://wsdEKjzeVnUDpn2AhPIVjPPzK4X.png)
>
>`IsPinnedShortcutsSupported`
>
>Checks whether the user's device launcher supports pinning shortcuts (Recommend use before `CreatePinnedShortcut`)
>
>- Returns - Boolean

### Kodular Community (Support)
https://community.kodular.io/t/opensource-testing-quickshortcuts-make-dynamic-and-pinned-shortcuts/159528
