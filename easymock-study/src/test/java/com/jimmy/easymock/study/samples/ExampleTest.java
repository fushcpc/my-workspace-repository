package com.jimmy.easymock.study.samples;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class ExampleTest {
    @TestSubject
    private ClassUnderTest classUnderTest = new ClassUnderTest();
    @Mock
    private Collaborator mock;

    @Test
    public void testRemoveNonExistingDocument() {
        EasyMock.replay(mock);
        classUnderTest.removeDocument("Does not exist");
    }

    @Test
    public void testAddDocument() {
        mock.documentAdded("New Document");
        EasyMock.replay(mock);
        classUnderTest.addDocument("New Document", new byte[0]);
    }

}
