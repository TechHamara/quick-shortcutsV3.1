# QuickShortcuts
**Backwards compatitble with versions < Android 7.1 (SDK 25). Features will only work when the user's device is Android => 7.1 (SDK 25)**

This is a extension that lets you add dynamic shortcuts as well as request user to pin shortcuts to the home screen.

Suggestions and bug reports are suggested as this is my second time dealing with Java and I might not be very experienced at it yet

This is a test release and the blocks included might change before release. If you plan to use it frequently, please think twice before using.

### Gallery
![Screenshot_20211221-153713|250x500, 75%](upload://189EVvYGqgecd39mmET55b1jscT.png) ![Screenshot_20211221-152622|250x500, 75%](upload://6atl0m1uQk4pynJlzGliQ3O3Ket.png)

### Block Documentation

> ![CreateShortcut|489x184, 75%](upload://e7Bf3aGffd9j7N9TQ96lezO6F2W.png)
>
>`CreateShortcut`
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

> ![RemoveAllShortcuts|327x29, 75%](upload://3Fj0DlSnybsiz24jIm2XvAdyGfL.png)
>
>`RemoveAllShortcuts`
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

> ![SupportsPinnedShortcuts|369x25, 75%](upload://z1b2KBbr3CPMb0ERKSVnXaXyq11.png)
>
>`SupportsPinnedShortcuts`
>
>Checks whether the user's device launcher supports pinning shortcuts (Recommend use before `CreatePinnedShortcut`)
>
>- Returns - Boolean

### Kodular Community (Support)
https://community.kodular.io/t/opensource-testing-quickshortcuts-make-dynamic-and-pinned-shortcuts/159528
