# Doplarr Debug Setup

## Quick Start

The app is **already running in debug mode** on port 5005!

### Current Debug Session Status
- **Status**: Running
- **Debug Port**: 5005
- **Terminal ID**: f6d8997a-12a8-498c-bf45-7ff2a2da1e5a
- **Config**: `/home/josh/Doplarr/config.edn` (with debug logging enabled)
- **Log Level**: DEBUG

### View Console Output
Open terminal and run:
```bash
# Check the running process
ps aux | grep java

# View logs from the running instance
tail -f ~/.config/doplarr/doplarr.log  # if it exists
```

### Debug in VS Code

1. **Open the project** in VS Code (already open at `/home/josh/Doplarr`)
2. **Go to Debug view** (Ctrl+Shift+D)
3. **Click "Attach to Doplarr Debug (Port 5005)"**
4. **Set breakpoints** in the source code
5. **App execution will pause at breakpoints**

### Available Debug Tasks

In VS Code, press Ctrl+Shift+B to see available build/run tasks:

- **Doplarr: Build & Debug** - Rebuilds JAR and starts debug session
- **Doplarr: Debug (No Build)** - Runs debug without rebuild

### Configuration

Edit `config.edn` to adjust:
- `log-level`: `:debug` (currently set for debugging)
- Discord token and API keys
- Service URLs (Sonarr, Radarr, Overseerr)

### Stop Debug Session

Press Ctrl+C in the terminal running the app, or:
```bash
kill -9 $(lsof -ti:5005)
```

### Restart Debug Session

```bash
cd /home/josh/Doplarr
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 \
  -Dconfig=config.edn -jar target/doplarr.jar
```

## Key Files

- **Source**: `src/doplarr/` - Clojure source code
- **Config**: `config.edn` - Runtime configuration
- **Build**: `build/build.clj` - Build script
- **Dependencies**: `deps.edn` - Clojure dependencies

## Useful Debug Commands

**Show stack trace** on error - already enabled with debug logging

**Check running JVM** on port 5005:
```bash
lsof -i :5005
```

**Check system logs**:
```bash
# Recent logs from current session
journalctl -n 50 -e
```
