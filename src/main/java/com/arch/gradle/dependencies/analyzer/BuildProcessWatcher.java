package com.arch.gradle.dependencies.analyzer;

import com.sun.nio.file.ExtendedWatchEventModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;
import java.text.MessageFormat;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Monitoring file changes in the directories of build process.
 *
 * @author antony.zhao@chase.com; yuechao.zhao@dieboldnixdorf.com
 * @since Oct, 2018
 */
public class BuildProcessWatcher {

    private static final String DIR_BUILD_PROCESS = "c:\\ant\\incubator\\";

    private static final Logger LOG = LoggerFactory.getLogger(BuildProcessWatcher.class);

    public static void main(String[] args) throws IOException {
        doWatch(DIR_BUILD_PROCESS);
    }

    private static void doWatch(String path) throws IOException {

        WatchService watcher = FileSystems.getDefault().newWatchService();

        Path dir = Paths.get(path);

        WatchEvent.Kind[] kg = {ENTRY_CREATE, ENTRY_DELETE};

        try {
            dir.register(watcher, kg, ExtendedWatchEventModifier.FILE_TREE); // This modifier is only available on windows platform.
        } catch (IOException x) {
            LOG.error(BuildProcessWatcher.class.toGenericString(), x);
        }

        for (; ; ) {

            // wait for key to be signaled
            WatchKey key;
            try {
                key = watcher.take();
            } catch (InterruptedException x) {
                LOG.error(BuildProcessWatcher.class.toGenericString(), x);
                return;
            }

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                // This key is registered only for ENTRY_CREATE events, but an OVERFLOW event can
                // occur regardless if events are lost or discarded.
                if (kind == OVERFLOW) {
                    LOG.warn("Events may have been lost or discarded");
                    continue;
                }

                // The filename is the context of the event.
                WatchEvent<Path> ev = (WatchEvent<Path>) event;

                String result = MessageFormat.format("{0} {1}", ev.kind(), ev.context());

                LOG.info(result);
            }

            // Reset the key -- this step is critical if you want to receive further watch events.
            // If the key is no longer valid, the directory is inaccessible so exit the loop.
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }
}
