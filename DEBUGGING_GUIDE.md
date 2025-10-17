# 🎯 Doplarr Debug Mode - Setup Complete

## ✅ Status: RUNNING IN DEBUG MODE

### Current Session
- **Process ID**: Running on terminal ID `1fc5adba-0c51-422c-b9b5-0f65b387bb99`
- **Debug Port**: `5005` (JDWP - Java Debug Wire Protocol)
- **Configuration**: Valid ✓
- **Log Level**: DEBUG
- **Status**: Listening for debugger connections

### Command Used
```bash
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 \
  -Dconfig=/home/josh/Doplarr/config.edn \
  -jar /home/josh/Doplarr/target/doplarr.jar
```

---

## 🔧 VS Code Debugging Setup

### Prerequisites
Install the **Debugger for Java** extension:
- Microsoft's "Extension Pack for Java" (includes Debugger for Java)
- Or install individually: `vscjava.vscode-java-debug`

### How to Attach Debugger

1. **Open VS Code** (if not already open):
   ```bash
   code /home/josh/Doplarr
   ```

2. **Go to Debug View**: Press `Ctrl+Shift+D`

3. **Select Configuration**: Dropdown shows "Attach to Doplarr Debug (Port 5005)"

4. **Start Debugging**: Click the green play button or press `F5`

5. **Set Breakpoints**: 
   - Click in the gutter next to line numbers in source files
   - Execution pauses when breakpoints are hit

6. **Use Debug Controls**:
   - Step Over: `F10`
   - Step Into: `F11`
   - Continue: `F5`
   - View Variables: Right-side panel shows locals and watches

### Example Breakpoints to Set

**File**: `src/doplarr/core.clj`
- Main entry point for the application

**File**: `src/doplarr/discord.clj`
- Discord bot interaction handling

**File**: `src/doplarr/backends/radarr.clj`
- Movie request processing

**File**: `src/doplarr/backends/sonarr.clj`
- TV show request processing

---

## 📋 Configuration (Debug Mode)

**File**: `/home/josh/Doplarr/config.edn`

```edn
{:sonarr/url "http://localhost:8989"
 :sonarr/api "test-api-key"
 :radarr/url "http://localhost:7878"
 :radarr/api "test-api-key"
 :discord/token "test-token-for-debug"
 :discord/max-results 10
 :log-level :debug  ; <- Debug logging enabled
}
```

### To Use Real Services:
Replace test values with your actual:
- Discord bot token
- Sonarr/Radarr URLs and API keys
- Overseerr credentials (optional)

---

## 🚀 Quick Commands

### Verify Debugger is Listening
```bash
lsof -i :5005
# or
netstat -tulpn | grep 5005
```

### View Real-Time Logs
```bash
# Logs are printed to console in the terminal
# Terminal ID: 1fc5adba-0c51-422c-b9b5-0f65b387bb99
```

### Stop the App
```bash
kill -9 $(lsof -ti:5005)
```

### Rebuild and Restart (Debug)
```bash
cd /home/josh/Doplarr
clj -T:build uber
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 \
  -Dconfig=/home/josh/Doplarr/config.edn \
  -jar target/doplarr.jar
```

---

## 📚 Key Source Files

| File | Purpose |
|------|---------|
| `src/doplarr/core.clj` | Application entry point |
| `src/doplarr/discord.clj` | Discord bot and slash commands |
| `src/doplarr/config.clj` | Configuration loading and validation |
| `src/doplarr/state.clj` | Application state management |
| `src/doplarr/backends/sonarr.clj` | Sonarr integration |
| `src/doplarr/backends/radarr.clj` | Radarr integration |
| `src/doplarr/backends/overseerr.clj` | Overseerr integration |

---

## 🐛 Debugging Tips

### View Variables and Watch Expressions
- Click on a variable to see its value
- Add custom watch expressions in Debug panel
- Use REPL-like evaluation in VS Code debug console

### Step Through Code
- **F10**: Step over (execute current line)
- **F11**: Step into (enter function calls)
- **Shift+F11**: Step out (exit current function)
- **F5**: Continue execution

### Common Breakpoint Patterns
1. Set on error handling lines
2. Set on Discord command handlers
3. Set on API request functions
4. Set on state updates

### View Call Stack
- Right-side panel shows the call stack
- Click to jump to different stack frames

---

## 🔗 Debug File Locations

- **VS Code Launch Config**: `.vscode/launch.json`
- **VS Code Tasks**: `.vscode/tasks.json`
- **Debug Guide**: `DEBUG.md` (this file)
- **Application Config**: `config.edn`
- **Build Script**: `build/build.clj`

---

## ⚠️ Troubleshooting

### "Debugger failed to attach"
- Ensure port 5005 isn't blocked
- Kill any existing Java process: `kill -9 $(lsof -ti:5005)`
- Restart with the full command above

### "Configuration is invalid"
- Check `config.edn` syntax (must be valid EDN)
- Ensure `:discord/token` is set
- Run with: `-Dconfig=/full/path/to/config.edn`

### No Debug Output Visible
- Check `:log-level` in `config.edn` is set to `:debug`
- Rebuild JAR: `clj -T:build uber`
- Restart the app

### Port Already in Use
```bash
# Find process using port 5005
lsof -i :5005
# Kill it
kill -9 <PID>
```

---

## 📖 Next Steps

1. **Attach VS Code debugger** (Ctrl+Shift+D → F5)
2. **Set breakpoints** in source code
3. **Interact with Discord bot** to trigger code paths
4. **Inspect variables** and state in debug panel
5. **Make code changes** and rebuild (Ctrl+Shift+B)

**Happy debugging! 🎉**
