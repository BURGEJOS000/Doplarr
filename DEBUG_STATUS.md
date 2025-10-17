# ✅ DOPLARR DEBUG MODE - COMPLETE SETUP

## 🎯 Current Status

### ✨ APP IS NOW RUNNING IN DEBUG MODE

```
Status: RUNNING ✓
Debug Port: 5005
Process: java -jar target/doplarr.jar (with JDWP debugging)
Config: /home/josh/Doplarr/config.edn
Log Level: DEBUG
Configuration Valid: ✓
```

### Console Output
```
Listening for transport dt_socket at address: 5005
Configuration is valid
Starting messaging process...
```

---

## 🚀 How to Debug in VS Code

### Step 1: Open VS Code
```bash
code /home/josh/Doplarr
```
✓ Already open from earlier

### Step 2: Open Debug View
- Press `Ctrl+Shift+D` (or click Debug icon on left sidebar)

### Step 3: Select Debug Configuration
- Click the dropdown that says **"Attach to Doplarr Debug (Port 5005)"**

### Step 4: Start Debugging
- Press `F5` or click the green play button

### Step 5: Set Breakpoints
- Open any `.clj` file in `src/doplarr/`
- Click on the line number gutter to set a breakpoint (red dot appears)

### Step 6: Interact with App
- Execute the Discord bot commands
- Execution pauses at your breakpoints
- Inspect variables in the Debug panel

---

## 🔧 What Was Built

### Build Artifacts
- ✅ **JAR File**: `/home/josh/Doplarr/target/doplarr.jar` (17 MB)
- ✅ **Compiled Classes**: `/home/josh/Doplarr/target/classes/`
- ✅ **Dependencies**: All resolved and included

### Configuration
- ✅ **Debug Config**: `.vscode/launch.json` - Debugger attachment configuration
- ✅ **Build Tasks**: `.vscode/tasks.json` - Quick build/run commands
- ✅ **App Config**: `config.edn` - Runtime settings (debug logging enabled)

### Documentation
- ✅ **DEBUGGING_GUIDE.md** - Comprehensive debugging guide
- ✅ **DEBUG.md** - Quick reference
- ✅ **This file** - Current status

---

## 📊 Build Information

```
Project: Doplarr v3.6.3
Language: 98.7% Clojure
Build System: Clojure CLI + seancorfield/build-clj
JDK Version: OpenJDK 21.0.8
Clojure CLI: 1.12.3
Java Debug: JDWP (Java Debug Wire Protocol)
```

---

## 🎮 VS Code Keyboard Shortcuts

| Shortcut | Action |
|----------|--------|
| `Ctrl+Shift+D` | Open Debug View |
| `F5` | Start/Continue Debugging |
| `F10` | Step Over |
| `F11` | Step Into |
| `Shift+F11` | Step Out |
| `Ctrl+Shift+B` | Show Build Tasks |
| `Ctrl+K Ctrl+V` | Open Preview (for markdown) |

---

## 📁 Project Structure

```
/home/josh/Doplarr/
├── src/
│   └── doplarr/                    # Main source code
│       ├── core.clj               # Entry point
│       ├── discord.clj            # Discord bot logic
│       ├── config.clj             # Configuration
│       ├── state.clj              # State management
│       └── backends/              # Service integrations
│           ├── sonarr.clj
│           ├── radarr.clj
│           └── overseerr.clj
├── build/
│   └── build.clj                  # Build script
├── config.edn                      # Runtime configuration (DEBUG MODE)
├── deps.edn                        # Dependencies
├── target/
│   └── doplarr.jar                # Compiled JAR (ready to run)
├── .vscode/
│   ├── launch.json                # Debug configuration
│   └── tasks.json                 # Build/run tasks
├── DEBUGGING_GUIDE.md             # Full debugging reference
└── DEBUG.md                        # Quick debug reference
```

---

## 🔄 Common Workflows

### Workflow 1: Debug Existing Build
```bash
# App is already running in debug mode!
# Just attach in VS Code: Ctrl+Shift+D → F5
```

### Workflow 2: Rebuild and Debug
```bash
# Option A: Use VS Code task
# Ctrl+Shift+B → Select "Doplarr: Build & Debug"

# Option B: Manual
cd /home/josh/Doplarr
clj -T:build uber
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 \
  -Dconfig=/home/josh/Doplarr/config.edn \
  -jar target/doplarr.jar
```

### Workflow 3: Change Config and Restart
```bash
# 1. Edit /home/josh/Doplarr/config.edn
# 2. Kill current process: kill -9 $(lsof -ti:5005)
# 3. Restart: (see Workflow 2 Option B)
```

### Workflow 4: View Live Logs
```bash
# Terminal is showing real-time output
# Terminal ID: c8ff476c-b151-4c3a-a083-53abaa0e3d53
# Access via terminal tab or:
lsof -i :5005  # Shows listening process
```

---

## 🛑 Stopping the App

### Option 1: Kill Debug Port
```bash
kill -9 $(lsof -ti:5005)
```

### Option 2: Kill by Process Name
```bash
killall java
```

### Option 3: Stop in Terminal
- Switch to the terminal running the app
- Press `Ctrl+C`

---

## 🐛 Debugging Tips & Tricks

### Set Breakpoints Strategically
1. **Core Logic**: `src/doplarr/core.clj` - Entry point
2. **Discord Commands**: `src/doplarr/discord.clj` - User interactions
3. **API Requests**: `src/doplarr/backends/*.clj` - Service calls
4. **State Updates**: `src/doplarr/state.clj` - Data changes

### Inspect Variables
- Hover over variables to see values
- Right-click variable → "Add to Watch"
- Use Debug Console to evaluate expressions

### Debug Console
- Press `` Ctrl+Shift+` `` to open integrated terminal
- Evaluate Clojure expressions while paused
- View logs and debug output

### Conditional Breakpoints
- Right-click breakpoint → "Add Conditional Breakpoint"
- Enter condition: `= x 5` (pause only when condition true)

---

## 📝 Configuration (Current Debug Settings)

**File**: `config.edn`

```edn
{:sonarr/url "http://localhost:8989"
 :sonarr/api "test-api-key"
 :radarr/url "http://localhost:7878"
 :radarr/api "test-api-key"
 :discord/token "test-token-for-debug"
 :discord/max-results 10
 :log-level :debug}
```

### To Use Production Values:
Replace these with your actual credentials from:
- Discord Developer Portal (bot token)
- Sonarr instance (Settings → General → API Key)
- Radarr instance (Settings → General → API Key)

---

## ✨ Next Steps

1. **Set a breakpoint**: Click line number in `src/doplarr/discord.clj`
2. **Attach debugger**: Ctrl+Shift+D → F5
3. **Interact with bot**: Send Discord commands
4. **Inspect state**: View variables in Debug panel
5. **Continue execution**: F5 to resume, F10 to step

---

## 📚 Learning Resources

- [Clojure Official Docs](https://clojure.org/)
- [VS Code Java Debugging](https://github.com/microsoft/vscode-java-debug)
- [JDWP Protocol](https://docs.oracle.com/javase/8/docs/technotes/guides/jpda/conninv.html)
- [Discljord (Discord Library)](https://github.com/IGJoshua/discljord)

---

## ✅ Verification Checklist

- [x] JAR built successfully
- [x] App starts without errors
- [x] Configuration is valid
- [x] Debug port 5005 is listening
- [x] Logging at DEBUG level
- [x] VS Code launch configuration ready
- [x] Build tasks configured
- [x] Documentation complete

---

**🎉 Everything is ready! Start debugging now by pressing Ctrl+Shift+D and then F5 in VS Code!**
